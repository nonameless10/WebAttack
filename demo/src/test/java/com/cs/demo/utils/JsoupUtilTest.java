package com.cs.demo.utils;

import org.junit.jupiter.api.Test;


class JsoupUtilTest {

    @Test
    void clean() {
        String test = "<h1 onclick='alert(1);'class='' style=''title=''>h1 内容 </h1><div class=''>div 内容 </div><p class='' style=''>p 内容 </p>";
        System.out.println(JsoupUtil.clean(test));
    }
}