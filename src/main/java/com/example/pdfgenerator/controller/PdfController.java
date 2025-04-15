package com.example.pdfgenerator.controller;

import com.example.pdfgenerator.model.PdfFormData;
import com.example.pdfgenerator.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("dados", new PdfFormData());
        return "formulario";
    }

    @PostMapping("/gerar")
    public String gerarPdf(@ModelAttribute PdfFormData dados, Model model) {
        String caminho = pdfService.gerarPdfComDados(dados);
        model.addAttribute("caminhoPdf", caminho);
        return "sucesso";
    }
}
