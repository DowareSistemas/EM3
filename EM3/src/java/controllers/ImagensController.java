/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.com.persistor.generalClasses.FileExtractor;
import br.com.persistor.interfaces.Session;
import dao.FotosDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.Fotos;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sessionProvider.SessionProvider;

/**
 *
 * @author Marcos Vinícius
 */
@Controller
@Scope(value = "request")
public class ImagensController
{

    public void delete(int id)
    {
        FotosDao fd = new FotosDao();

        Fotos f = fd.find(id);
        fd.delete(f);
        fd.commit();
    }

    @RequestMapping(value = "img-save", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String save(@RequestParam(value = "id") int id, HttpServletRequest request)
    {
        try
        {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
            List<FileItem> items = fileUpload.parseRequest(request);
            if (items.isEmpty())
                return "0";

            Fotos foto = new Fotos();
            foto.setId(id);
            foto.setFoto(items.get(0).getInputStream());

            FotosDao fd = new FotosDao(true);
            fd.save(foto);

            return (foto.saved || foto.updated
                    ? new OperationResult(StatusRetorno.OPERACAO_OK, "Imagem salva.", foto.getId()).toJson()
                    : new OperationResult(StatusRetorno.FALHA_INTERNA, "Ocorreu um problema ao salvar a imagem. Acione o suporte Doware", 0).toJson());

        }
        catch (Exception ex)
        {

        }
        return "";
    }

    @RequestMapping(value = "img-get", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String get(@RequestParam(value = "id") int id, @RequestParam(value = "nome") String nome, HttpServletRequest request)
    {
        SessionProvider.setConfig(request);
        String path = (Utility.getPath("img", request) + nome + id + ".jpg");

        FotosDao fd = new FotosDao(true);
        Fotos foto = fd.find(id);

        if (foto.getId() == 0)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "", "").toJson();

        if (foto.getFoto() == null)
            return new OperationResult(StatusRetorno.NAO_ENCONTRADO, "Não ha imagem a ser extraída.", "").toJson();

        FileExtractor extractor = new FileExtractor();
        extractor.setBufferSize(1024);
        extractor.setFileToExtract(path);
        extractor.setInputStream(foto.getFoto());
        extractor.extract();

        return new OperationResult(StatusRetorno.OPERACAO_OK, "Imagem exraída com exito.", "img/" + nome + id + ".jpg").toJson();
    }
}
