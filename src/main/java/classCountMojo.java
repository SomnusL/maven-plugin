import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.*;

/**
 * Created by pliu on 2018/12/16.
 * 自定义maven插件,调用时传参${basedir},统计java文件数量
 */
@Mojo(name = "classCount",defaultPhase = LifecyclePhase.PACKAGE)
public class classCountMojo extends AbstractMojo {

    /**
     * 计数器
     */
    private static int count = 0;

    @Parameter
    private String basedir;

    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("basedir: " + basedir);
        System.out.println("============start count============");
        listDir(basedir);
        System.out.println("============ end count ============");
        System.out.println("============ count: " + count + "============");

    }

    private void listDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("path is not exists!");
            return;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                this.listDir(files[i].getAbsolutePath());
            }
        } else {
            if (file.getAbsolutePath().endsWith(".java")) {
                System.out.println(file.getAbsolutePath());
                count++;
            }
        }
    }
}
