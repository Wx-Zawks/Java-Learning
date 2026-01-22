package demo.zhouzhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clazz {
    private Integer id; //ID
    private String name; //班级名称
    private String room; //班级教室
    private LocalDate beginDate; //开课时间
    private LocalDate endDate; //结课时间
    private Integer masterId; //班主任
    private Integer subject; //学科
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间

    private String masterName; //班主任姓名
    private String status; //班级状态 - 未开班 , 在读 , 已结课

    public void setClazzStatus(){
        if (LocalDateTime.now().isBefore(this.getBeginDate().atStartOfDay())) {
            this.setStatus("未开班");
        } else if (LocalDateTime.now().isAfter(this.getEndDate().atStartOfDay())) {
            this.setStatus("已结课");
        } else  {
            this.setStatus("在读中");
        }
    }
}