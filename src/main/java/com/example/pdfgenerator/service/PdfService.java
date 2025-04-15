package com.example.pdfgenerator.service;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.pdfgenerator.model.PdfFormData;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

@Service
public class PdfService {

    public String gerarPdfComDados(PdfFormData dados) {
        try {
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy");

            String pdfPath = "c:\\pdf\\Instalacao_" + dados.getNomePonto() + agora.format(formatter) + ".pdf";
            File directory = new File("c:\\pdf");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();
            document.setMargins(12, 12, 15, 15);

            document.add(new Paragraph("     "));
            document.add(new Paragraph("----------------   INSTALAÇÃO DE EQUIPAMENTOS   ---------------- "));
            document.add(new Paragraph("      "));
            document.add(new Paragraph(" Nome do Ponto: " + dados.getNomePonto().toUpperCase()));
            document.add(new Paragraph(" Endereço: " + dados.getEndereco()));
            document.add(new Paragraph(" Leiturista: " + dados.getLeiturista()));
            document.add(new Paragraph(" Contato: " + dados.getContato()));
            document.add(new Paragraph(" Tel: " + dados.getTelefone()));
            document.add(new Paragraph("   "));
            document.add(new Paragraph(" Maquina: " + "Maq." +dados.getMaquina()));
            document.add(new Paragraph(" Jogo: " + dados.getJogo()));
            document.add(new Paragraph(" Entradas: " + dados.getE()));
            document.add(new Paragraph(" Saidas: " + dados.getS()));
            document.add(new Paragraph(" Placa: " + dados.getPlaca()));
            document.add(new Paragraph("   "));

            document.close();

            return pdfPath ;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
