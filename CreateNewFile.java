import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreateNewFile {
    // absolute path
    private static final String absolutePath = "solution";
    private static final String simple = "CH_";
    private static final String Java = ".java";
    private static final String MarkdownPath = "README.md"; // 指定Markdown文件的路径
    private String solutionMarkdownPath;
    private String filename;
    private String folderPath;
    private String filePath;
    private String MainMDText;
    public CreateNewFile(String filename){
        this.filename = filename;

        dataProcess();
        createFolderAndFile();
        editMarkdown();
    }
    public void createFolderAndFile() {

        File folderFile = new File(folderPath);
        if ( ! folderFile.exists()) {
            folderFile.mkdir();
            System.out.println("文件夹 。。。 创建成功");
        }

        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("Java文件 。。。 创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File mdfile = new File(solutionMarkdownPath);
        try {
            mdfile.createNewFile();
            System.out.println("Note markdown 。。。 创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void dataProcess(){
        // file and folder data process
        // replace " " by "_"
        filename = filename
                .replace(" ", "_")
                .replace("._",".");
        // document file path

        folderPath = absolutePath + "/" + filename ;
        filePath = folderPath + "/" + simple + filename + Java;
        solutionMarkdownPath = folderPath + "/"  +  MarkdownPath;

        // markdown data process
        String id = "|" + filename.split("\\.")[0] + "|";

        String porblem = "[" + filename + "]";
        String link = "(" + filePath +")" + "|";
        String markdown = "[Note]("+solutionMarkdownPath + ")|";
        MainMDText = id + porblem + link + markdown;
    }

    public void editMarkdown(){
        try {
            // 读取Markdown文件的所有行
            List<String> lines = Files.readAllLines(Paths.get(MarkdownPath), StandardCharsets.UTF_8);

            // 检查是否有内容要添加
            if (!MainMDText.isEmpty() && !lines.contains(MainMDText)) {
                // 如果最后一行不是以换行符结束，则添加换行符
//                if (!lines.get(lines.size() - 1).endsWith("\n")) {
//                    lines.add(""); // 添加一个空行作为分隔
//                }
                // 在最后一行之后添加新内容
                lines.add(MainMDText);
                // 将更新后的内容写回文件
                Files.write(Paths.get(MarkdownPath), lines, StandardCharsets.UTF_8);
                System.out.println("github Markdown 修改成功");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while appending to the Markdown file: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        // file name
        String fileName = "216. Combination Sum III";

        new CreateNewFile(fileName);

    }

}
