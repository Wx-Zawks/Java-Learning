package demo.zhouzhou.utils;

import java.util.ArrayList;
import java.util.List;

public class NumberStringParser {

    /**
     * 提取逗号分隔的数字字符串中的数字，存入 Integer 类型的 List
     * @param numStr 输入字符串，如 "1"、"2,5,13"、null、"" 等
     * @return 包含数字的 List，若输入无效则返回空 List
     */
    public static List<Integer> parseNumStringToList(String numStr) {
        // 初始化空集合，避免返回 null
        List<Integer> numList = new ArrayList<>();

        // 1. 处理空值/空字符串
        if (numStr == null || numStr.trim().isEmpty()) {
            return numList;
        }

        // 2. 分割字符串（先去除首尾空格，再按逗号分割）
        String[] numStrArray = numStr.trim().split(",");

        // 3. 遍历并转换为数字
        for (String s : numStrArray) {
            // 去除单个数字字符串的前后空格（处理 "2,  5 ,13" 这种带空格的情况）
            String trimedStr = s.trim();
            // 过滤空字符串（处理 "2,,5" 这种情况）
            if (trimedStr.isEmpty()) {
                continue;
            }
            try {
                // 转换为 Integer（若需要 Long 类型，改用 Long.parseLong(trimedStr)）
                Integer num = Integer.parseInt(trimedStr);
                numList.add(num);
            } catch (NumberFormatException e) {
                // 遇到非数字字符串时，跳过（也可根据需求抛异常/打印日志）
                System.out.println("跳过非数字字符：" + trimedStr);
            }
        }

        return numList;
    }
}