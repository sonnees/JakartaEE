package vn.edu.iuh.fit.frontend.controllers.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.dto.Statistic2Field;
import vn.edu.iuh.fit.backend.dto.Statistic2Field_Money;
import vn.edu.iuh.fit.backend.services.OrderService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/statistic")
@AllArgsConstructor
public class StatisticsController {
    OrderService orderService;

    @GetMapping("/total-order-day-month")
    public String getTotalOrderDayMonth(
            Model model,
            @ModelAttribute(value = "date") @Validated Optional<LocalDate> date
    ) {
        LocalDate temp = date.orElseGet(LocalDate::now);
        String name = "Biểu đồ thể hiện tổng số hóa đơn của mỗi ngày trong tháng " + temp.getMonthValue();
        List<Statistic2Field> statistic2Fields = orderService.statisticDayInMonth(LocalDateTime.of(temp.getYear(),temp.getMonth(),temp.getDayOfMonth(),0,0,0));
        model.addAttribute("data", statistic2Fields);
        model.addAttribute("nameChart", name);
        model.addAttribute("date", temp);
        model.addAttribute("status", 1);
        model.addAttribute("label", "Số lượng");
        return "admin/home";
    }

    @GetMapping("/total-order-month-year")
    public String getTotalOrderMonthYear(
            Model model,
            @ModelAttribute(value = "date") @Validated Optional<LocalDate> date
    ){
        LocalDate temp = date.orElseGet(LocalDate::now);
        String name = "Biểu đồ thể hiện tổng số hóa đơn của mỗi tháng trong năm " + temp.getYear();
        List<Statistic2Field> statistic2Fields = orderService.statisticMonthInYear(LocalDateTime.of(temp.getYear(),temp.getMonth(),temp.getDayOfMonth(),0,0,0));
        model.addAttribute("nameChart", name);
        model.addAttribute("data", statistic2Fields);
        model.addAttribute("date", temp);
        model.addAttribute("status", 2);
        model.addAttribute("label", "Số lượng");
        return "admin/home";
    }

    @GetMapping("/total-money-day-month")
    public String statisticDayInMonth_Money(
            Model model,
            @ModelAttribute(value = "date") @Validated Optional<LocalDate> date
    ) {
        LocalDate temp = date.orElseGet(LocalDate::now);
        String name = "Biểu đồ thể hiện tổng doanh thu của mỗi ngày trong tháng " + temp.getMonthValue();
        List<Statistic2Field_Money> statistic2FieldMonies = orderService.statisticDayInMonth_Money(LocalDateTime.of(temp.getYear(), temp.getMonth(), temp.getDayOfMonth(), 0, 0, 0));
        model.addAttribute("data", statistic2FieldMonies);
        model.addAttribute("nameChart", name);
        model.addAttribute("date", temp);
        model.addAttribute("status", 3);
        model.addAttribute("label", "Doanh số");
        return "admin/home";
    }

    @GetMapping("/total-money-month-year")
    public String statisticMonthInYear_Money(
            Model model,
            @ModelAttribute(value = "date") @Validated Optional<LocalDate> date
    ) {
        LocalDate temp = date.orElseGet(LocalDate::now);
        String name = "Biểu đồ thể hiện tổng doanh thu của mỗi tháng trong năm " + temp.getYear();
        List<Statistic2Field_Money> statistic2FieldMonies = orderService.statisticMonthInYear_Money(LocalDateTime.of(temp.getYear(), temp.getMonth(), temp.getDayOfMonth(), 0, 0, 0));
        model.addAttribute("data", statistic2FieldMonies);
        model.addAttribute("nameChart", name);
        model.addAttribute("date", temp);
        model.addAttribute("status", 4);
        model.addAttribute("label", "Doanh số");
        return "admin/home";
    }

}
