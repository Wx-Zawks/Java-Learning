package demo.zhouzhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQueryParam {
    private Integer clazzId;
    private Integer degree;
    private String name;
    private Integer page = 1;
    private Integer pageSize = 10;
}
