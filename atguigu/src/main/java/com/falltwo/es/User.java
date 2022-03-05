package com.falltwo.es;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: FallTwo
 * @createTime: 2022/3/5 10:48
 * @description:
 */
@Data
@AllArgsConstructor
public class User {
    String name;
    String sex;
    Integer age;
}
