package com.room.hub.Class;

import java.io.FileWriter;
import java.io.IOException;

public class Etiqueta {
    public void generateZPLFile(String firstName, String lastName, String amount, String date, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            StringBuilder builder = new StringBuilder();
            builder.append("^XA\n");
            builder.append("^CI28\n");
            builder.append("^FO50,50\n");
            builder.append("^GB700,400,2^FS //Tamanho\n");
            builder.append("^FO200,80\n");
            builder.append("^A0N,50,50\n");
            builder.append("^FDInformação Financeira^FS\n");
            builder.append("^FO70,130\n");
            builder.append("^GB660,2,2^FS // Linha divisória\n");
            builder.append("^FO100,150\n");
            builder.append("^A0N,40,40\n");
            builder.append("^FDNome:^FS\n");
            builder.append("^FO210,150\n");
            builder.append("^A0N,40,40\n");
            builder.append("^FD[Valor do Nome]^FS\n");
            builder.append("^FO100,220\n");
            builder.append("^A0N,40,40\n");
            builder.append("^FDSobrenome:^FS\n");
            builder.append("^FO300,220\n");
            builder.append("^A0N,40,40\n");
            builder.append("^FD[Valor do Sobrenome]^FS\n");
            builder.append("^FO100,290\n");
            builder.append("^A0N,40,40\n");
            builder.append("^FDAmount:^FS\n");
            builder.append("^FO235,290\n");
            builder.append("^A0N,40,40\n");
            builder.append("^FD[R$ Valor]^FS\n");
            builder.append("^FO100,360\n");
            builder.append("^A0N,40,40\n");
            builder.append("^FDDate:^FS\n");
            builder.append("^FO200,360\n");
            builder.append("^A0N,40,40\n");
            builder.append("^FD[Data]^FS\n");
            builder.append("^XZ\n");

            String zplCode = builder.toString(); // Usando 'builder' para obter o código ZPL
            writer.write(zplCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "C:/Room/hub/etiquetas/etiqueta.zpl";
        Etiqueta etiq = new Etiqueta();

        etiq.generateZPLFile("[Valor do Nome]", "[Valor do Sobrenome]", "[R$ Valor]", "[Data]", filePath); //Váriaveis precisam ser setadas em tela para trocar os [] para virem de acorod com informações do usuário em tela.
        System.out.println("Código ZPL gerado em: " + filePath);
    }
}
