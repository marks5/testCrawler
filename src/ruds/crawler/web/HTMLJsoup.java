package ruds.crawler.web;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ruds.crawler.cache.Cache;
import ruds.crawler.model.Carro;
import ruds.crawler.model.Produto;

public class HTMLJsoup 
{  

	public HTMLJsoup(String html)
    {
		
		System.out.println("HtmlJsoup");
		
        if(Cache.produtosCache == null) 
        {
            Cache.produtosCache = new ArrayList<>();
        }
        
        try
        {
        	
        	System.out.println("HtmlJsoup try");
            // Parse the String into a Jsoup Document
            Document doc = Jsoup.parse(html);
            
                
            Produto produtoObj = new Produto();
            
            
            
              produtoObj.setCodigoProduto(doc.getElementsByClass("codigo-ds").get(0).child(1).text());
              System.out.println("Código Produto: " + produtoObj.getCodigoProduto());
            
              produtoObj.setDescricaoProduto(doc.getElementsByClass("detalhes").get(0).child(0).text());
              System.out.println("Descrição Produto: " + produtoObj.getDescricaoProduto());

              produtoObj.setOutrosCodigoProduto(doc.getElementsByClass("codigo-ds").get(0).child(3).text());
              System.out.println("Outros Códigos: " + produtoObj.getOutrosCodigoProduto());
              
              produtoObj.setDetalhesProduto(doc.getElementsByClass("detalhes").get(0).child(1).text());
              System.out.println("Detalhes: " + produtoObj.getDetalhesProduto());          
                       
              
              
              Elements tr = doc.getElementsByClass("infos").get(0).getElementsByTag("tbody").get(0)
            		  .getElementsByTag("tr");   	
              
              for(int i=0;i<tr.size();i++){
            	
            	Carro carroObj = new Carro();
            	  
            	carroObj.setMontadora(tr.get(i).getElementsByClass("montadora").text());
                carroObj.setModelo(tr.get(i).getElementsByClass("modelo").text());
                carroObj.setMotor(tr.get(i).getElementsByClass("motor").text());
                carroObj.setAno(tr.get(i).getElementsByClass("ano").text());
                carroObj.setComplemento(tr.get(i).getElementsByClass("complemento").text());
                
              System.out.println("---------------------------");
          	  System.out.println("Montadora: " + carroObj.getMontadora());
          	  System.out.println("Modelo: " + carroObj.getModelo());
          	  System.out.println("Motor: " + carroObj.getMotor());
          	  System.out.println("Ano: " + carroObj.getAno());
          	  System.out.println("Complemento: " + carroObj.getComplemento());
          	  System.out.println("ID Carro: " + carroObj.getId());
          	  System.out.println("---------------------------");
                
                
               produtoObj.getListaCarros().add(carroObj);
               
               Cache.carrosCache.add(carroObj);
             }
              
              
              Cache.produtosCache.add(produtoObj);
              
              System.out.println("Lista Carros: " + produtoObj.getListaCarros().size());
              
              System.out.println("Tamanho cache carros: " + Cache.carrosCache.size());

        }
        catch(Exception erro)
        {
            System.out.println(erro.getMessage());
        }  
    }

}
