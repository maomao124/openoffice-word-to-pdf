package mao.openofficewordtopdf;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jodconverter.core.DocumentConverter;
import org.jodconverter.core.document.DocumentFormat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.CountDownLatch;

@Slf4j
@SpringBootTest
class OpenofficeWordToPdfApplicationTests
{
    @Autowired
    private DocumentConverter documentConverter;

    @SneakyThrows
    @Test
    void contextLoads()
    {
        documentConverter.convert(new File("./test.docx")).to(new File("./test.pdf")).execute();
    }

    @SneakyThrows
    @Test
    void contextLoads2()
    {
        documentConverter.convert(new File("./template-test2.docx")).to(new File("./template-test2.pdf")).execute();
    }


    @SneakyThrows
    @Test
    void contextLoads3()
    {
        CountDownLatch countDownLatch = new CountDownLatch(32);
        for (int i = 0; i < 32; i++)
        {
            new Thread(new Runnable()
            {
                @SneakyThrows
                @Override
                public void run()
                {
                    documentConverter.convert(new File("./test.docx")).to(new File("./test.pdf")).execute();
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();

    }

    @SneakyThrows
    @Test
    void contextLoads4()
    {
        documentConverter.convert(new File("./test.ppt")).to(new File("./test3.pdf")).execute();
    }


    @SneakyThrows
    @Test
    void contextLoads5()
    {
        DocumentFormat documentFormatSrc = documentConverter.getFormatRegistry().getFormatByExtension("docx");
        DocumentFormat documentFormatTarget = documentConverter.getFormatRegistry().getFormatByExtension("pdf");
        documentConverter.convert(
                new FileInputStream(new File("./test.docx")))
                .as(documentFormatSrc)
                .to(new FileOutputStream("./test.pdf"))
                .as(documentFormatTarget).execute();

        //response.setContentType("application/application");
        //response.setHeader("Content-disposition", "attachment;filename="+new String("example.a.pdf".getBytes("iso-8859-1")));
    }
}
