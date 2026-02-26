package demo.zhouzhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzStatisticVO {
    private List<String> clazzList;
    private List<Integer> dataList;
}
