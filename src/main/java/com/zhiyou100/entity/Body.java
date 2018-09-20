package com.zhiyou100.entity;

import lombok.Data;

import java.util.List;

/**
 * @author yuanziyan
 * @ClassName Body
 * @Direction TODO
 * @data 2018/9/19 22:17
 */
@Data
public class Body {
   private String confidence;
   private List<Integer> thresholds;
   private List<Integer> rectA;
   private List<Integer> rectB;
   private int error;
   private String requestId;
}
