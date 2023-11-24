package mao.openofficewordtopdf.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mao.openofficewordtopdf.service.DocumentConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * Project name(项目名称)：openoffice-word-to-pdf
 * Package(包名): mao.openofficewordtopdf.controller
 * Class(类名): DocumentConverterController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/11/23
 * Time(创建时间)： 9:13
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Controller
@RequestMapping("/api")
public class DocumentConverterController
{

    @Autowired
    private DocumentConverterService documentConverterService;

    /**
     * 文档转换接口
     *
     * @param httpServletResponse HttpServletResponse对象
     * @param sourceFileSuffix    源文件后缀
     * @param targetFileSuffix    目标文件后缀
     */
    @SneakyThrows
    @PostMapping("/converter/{sourceFileSuffix}/{targetFileSuffix}")
    public void converter(HttpServletResponse httpServletResponse,
                          @PathVariable String sourceFileSuffix,
                          @PathVariable String targetFileSuffix,
                          MultipartFile file)
    {
        String originalFilename = file.getOriginalFilename();
        log.info(originalFilename);
        log.info(sourceFileSuffix + "->" + targetFileSuffix);
        String[] split = originalFilename.split("\\.");
        //类型有问题
        httpServletResponse.setContentType("application/" + targetFileSuffix);
        httpServletResponse.setHeader("Content-disposition",
                "attachment;filename=" + new String((split[0] + "." + targetFileSuffix)
                        .getBytes("utf-8"), "iso-8859-1"));
        documentConverterService.converter(file.getInputStream(),
                httpServletResponse.getOutputStream(),
                sourceFileSuffix,
                targetFileSuffix);
    }
}
