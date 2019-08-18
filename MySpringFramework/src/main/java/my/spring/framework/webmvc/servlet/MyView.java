package my.spring.framework.webmvc.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyView {

    public static final String DEFAULT_CONTENT_TYPE = "text/html;charset=utf-8";

    private File viewFile;

    public MyView() {
    }

    public MyView(File templateFile) {

        this.viewFile = templateFile;
    }

    public String getContentType() {
        return DEFAULT_CONTENT_TYPE;
    }

    public void render(Map<String, ?> model, HttpServletRequest req, HttpServletResponse resp) throws Exception {

        StringBuffer sb = new StringBuffer();
        RandomAccessFile ra = new RandomAccessFile(this.viewFile, "r");

        try {
            String line = null;

            while (null != (line = ra.readLine())) {
                line = new String(line.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                System.out.println("line: " + line);
                Pattern pattern = Pattern.compile("\\*\\{[^\\}]+\\}", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    System.out.println("========================");
                    String paramName = matcher.group();
                    System.out.println("paramName: " + paramName);
                    paramName = paramName.replaceAll("\\*\\{|\\}", "");
                    Object paramValue = model.get(paramName);
                    if (paramName == null) {
                        continue;
                    }
                    System.out.println("paramValue.toString()" + paramValue.toString());
                    line = matcher.replaceFirst(makeStringForRegExp(paramValue.toString()));
                    matcher = pattern.matcher(line);
                }
                sb.append(line);
            }
        } finally {
            ra.close();
        }

        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(sb.toString());
    }

    private String makeStringForRegExp(String str) {
        return str.replace("\\", "\\\\").replace("*", "\\*")
                .replace("+", "\\+").replace("|", "\\|")
                .replace("{", "\\{").replace("}", "\\}")
                .replace("(", "\\(").replace(")", "\\)")
                .replace("^", "\\^").replace("$", "\\$")
                .replace("[", "\\[").replace("]", "\\]")
                .replace("?", "\\?").replace(",", "\\,")
                .replace(".", "\\.").replace("&", "\\&");
    }
}
