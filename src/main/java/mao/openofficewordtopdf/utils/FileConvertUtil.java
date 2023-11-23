package mao.openofficewordtopdf.utils;

import org.jodconverter.core.DocumentConverter;
import org.jodconverter.core.document.DefaultDocumentFormatRegistry;
import org.jodconverter.core.document.DocumentFormat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Project name(项目名称)：openoffice-word-to-pdf
 * Package(包名): mao.openofficewordtopdf.utils
 * Class(类名): FileConvertUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/11/22
 * Time(创建时间)： 22:29
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class FileConvertUtil
{
    /**
     * 默认转换后文件后缀
     *//*
    private static final String DEFAULT_SUFFIX = "pdf";
    *//**
     * openoffice_port
     *//*
    private static final Integer OPENOFFICE_PORT = 8100;

    *//**
     * 方法描述 office文档转换为PDF(处理本地文件)      *      * @param sourcePath 源文件路径      * @param suffix     源文件后缀      * @return InputStream 转换后文件输入流
     *//*
    public static InputStream convertLocaleFile(String sourcePath, String suffix) throws Exception
    {
        File inputFile = new File(sourcePath);
        InputStream inputStream = new FileInputStream(inputFile);
        return covertCommonByStream(inputStream, suffix);
    }

    *//**
     * 方法描述  office文档转换为PDF(处理网络文件)      *      * @param netFileUrl 网络文件路径      * @param suffix     文件后缀      * @return InputStream 转换后文件输入流
     *//*
    public static InputStream convertNetFile(String netFileUrl, String suffix) throws Exception
    {
        // 创建URL
        URL url = new URL(netFileUrl);
        // 试图连接并取得返回状态码
        URLConnection urlconn = url.openConnection();
        urlconn.connect();
        HttpURLConnection httpconn = (HttpURLConnection) urlconn;
        int httpResult = httpconn.getResponseCode();
        if (httpResult == HttpURLConnection.HTTP_OK)
        {
            InputStream inputStream = urlconn.getInputStream();
            return covertCommonByStream(inputStream, suffix);
        }
        return null;
    }

    *//**
     * 方法描述  将文件以流的形式转换      *      * @param inputStream 源文件输入流      * @param suffix      源文件后缀      * @return InputStream 转换后文件输入流
     *//*
    public static InputStream covertCommonByStream(InputStream inputStream, String suffix) throws Exception
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        OpenOfficeConnection connection = new SocketOpenOfficeConnection(OPENOFFICE_PORT);
        connection.connect();
        DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
        DefaultDocumentFormatRegistry formatReg = new DefaultDocumentFormatRegistry();
        DocumentFormat targetFormat = formatReg.getFormatByFileExtension(DEFAULT_SUFFIX);
        DocumentFormat sourceFormat = formatReg.getFormatByFileExtension(suffix);
        converter.convert(inputStream, sourceFormat, out, targetFormat);
        connection.disconnect();
        return outputStreamConvertInputStream(out);
    }

    *//**
     * 方法描述 outputStream转inputStream
     *//*
    public static ByteArrayInputStream outputStreamConvertInputStream(final OutputStream out) throws Exception
    {
        ByteArrayOutputStream baos = (ByteArrayOutputStream) out;
        return new ByteArrayInputStream(baos.toByteArray());
    }

    public static void main(String[] args) throws IOException
    {
        //convertNetFile("http://172.16.10.21/files/home/upload/department/base/201912090541573c6abdf2394d4ae3b7049dcee456d4f7.doc", ".pdf");
        //convert("c:/Users/admin/Desktop/2.pdf", "c:/Users/admin/Desktop/3.pdf");
    }*/
}
