package demo.zhouzhou.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ClazzQueryParam {
    private String name;
    private Integer page;
    private Integer pageSize;
    @DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate end;
}
