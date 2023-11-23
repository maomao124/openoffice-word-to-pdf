package mao.openofficewordtopdf.service.impl;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：openoffice-word-to-pdf
 * Package(包名): mao.openofficewordtopdf.service.impl
 * Class(测试类名): DocumentConverterServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/11/23
 * Time(创建时间)： 9:03
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class DocumentConverterServiceImplTest
{
    @Autowired
    private DocumentConverterServiceImpl documentConverterService;

    @Test
    void converter()
    {
        documentConverterService.converter("./test.docx", "./test4.html");
    }

    @Test
    void testConverter()
    {
        documentConverterService.converter(new File("./test.docx"), new File("./test5.pdf"));
    }

    @SneakyThrows
    @Test
    void testConverter1()
    {
        documentConverterService.converter(new FileInputStream("./test.ppt")
                , new FileOutputStream("./test6.pdf")
                , "ppt", "pdf");
    }
}
