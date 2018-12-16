# maven-plugin
## maven自定义插件的一个小demo,浅显易懂

## 使用方式: 
- 1,将本demo下载到本地,在项目根路径命令行执行:mvn install
- 2,在你自己项目的pom.xml文件中添加:
    
    ```
    <plugin>
        <groupId>com.pliu</groupId>
        <artifactId>classConut-plugin</artifactId>
        <version>1.0-SNAPSHOT</version>
        <configuration>
            <!-- ${basedir} 内置属性:项目根路径 -->
            <basedir>${basedir}</basedir>
        </configuration>
    </plugin>
    ```
- 3,利用idea运行插件:
![](https://upload-images.jianshu.io/upload_images/2184521-28bc3042bb47aea4.png?imageMogr2/auto-orient/)
 选中插件,点击运行按钮即可
