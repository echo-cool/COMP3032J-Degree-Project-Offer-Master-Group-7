package com.group7;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.apache.log4j.BasicConfigurator;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖保佑             永无BUG
//          佛曰:
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？

//                       .::::.
//                     .::::::::.
//                    :::::::::::
//                 ..:::::::::::'
//              '::::::::::::'
//                .::::::::::
//           '::::::::::::::..
//                ..::::::::::::.
//              ``::::::::::::::::
//               ::::``:::::::::'        .:::.
//              ::::'   ':::::'       .::::::::.
//            .::::'      ::::     .:::::::'::::.
//           .:::'       :::::  .:::::::::' ':::::.
//          .::'        :::::.:::::::::'      ':::::.
//         .::'         ::::::::::::::'         ``::::.
//     ...:::           ::::::::::::'              ``::.
//    ````':.          ':::::::::'                  ::::..
//                       '.:::::'                    ':'````..
//

/***
 *                   /88888888888888888888888888\
 *                   |88888888888888888888888888/
 *                    |~~____~~~~~~~~~"""""""""|
 *                   / \_________/"""""""""""""\
 *                  /  |              \         \
 *                 /   |  88    88     \         \
 *                /    |  88    88      \         \
 *               /    /                  \        |
 *              /     |   ________        \       |
 *              \     |   \______/        /       |
 *   /"\         \     \____________     /        |
 *   | |__________\_        |  |        /        /
 * /""""\           \_------'  '-------/       --
 * \____/,___________\                 -------/
 * ------*            |                    \
 *   ||               |                     \
 *   ||               |                 ^    \
 *   ||               |                | \    \
 *   ||               |                |  \    \
 *   ||               |                |   \    \
 *   \|              /                /"""\/    /
 *      -------------                |    |    /
 *      |\--_                        \____/___/
 *      |   |\-_                       |
 *      |   |   \_                     |
 *      |   |     \                    |
 *      |   |      \_                  |
 *      |   |        ----___           |
 *      |   |               \----------|
 *      /   |                     |     ----------""\
 * /"\--"--_|                     |               |  \
 * |_______/                      \______________/    )
 *                                               \___/
 */

@SpringBootApplication
//@EnableAdminServer
@MapperScan("com.group7.db.mappers")
@EnableWebSocket
@ServletComponentScan(basePackages = "com.group7")
public class MainApplication {
    public static void main(String[] args) {
//        BasicConfigurator.configure();
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ServerEndpointExporter serverEndpoint(){
        ServerEndpointExporter serverEndpointExporter = new ServerEndpointExporter();
        return serverEndpointExporter;
    }
}
