/**
 * Project Name:hotel-admin
 * File Name:UniqueTest.java
 * Package Name:com.java.test
 * Date:下午3:39:52
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package com.java.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description: Date: 下午3:39:52 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
public class UniqueTest {

    public static void main(String[] args) throws Exception {

        /*
         * String str = "1,1,1,2,2,3,4,5,10,12,14,";// --->"1,2,3,4,5,10,12,14,"
         * // String str = "aabcddef"; str = str.replaceAll("(.,)\\1+", "$1");
         * System.out.println(str);
         */
        // yyyy-MM-dd HH:mm:ss
        String inTime = "2019-01-12 12:12:12";
        String outTime = "2019-02-13 14:12:50";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date it = sdf.parse(inTime);
        Date ot = sdf.parse(outTime);
        int days = ot.compareTo(it);
        System.out.println("days=" + days);

    }

}
