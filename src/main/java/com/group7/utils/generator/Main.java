package com.group7.utils.generator;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/22-18:42
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.generator
 * @Description:
 **/

import org.mybatis.generator.api.ShellRunner;

/**
 *
 * @author wangmengjun
 *
 */
public class Main {

    public static void main(String[] args) {

        String config = Main.class.getClassLoader()
                .getResource("generatorConfig.xml").getFile();
        String[] arg = { "-configfile", config, "-overwrite" };
        ShellRunner.main(arg);
    }
}