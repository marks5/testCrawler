package ruds.crawler.web;

import java.util.ArrayList;

import ruds.crawler.cache.Cache;
import ruds.crawler.rn.ProdutoRN;

public class Principal 
{
	public static void main(String[] args)
    {
		
		ProdutoRN produto = new ProdutoRN();
		
//		CarroRN carro = new CarroRN();
		
        try
        {
            Cache.produtosCache = new ArrayList<>();
            
            Cache.carrosCache = new ArrayList<>();
            
            CrawlerControl.executarCrawler();
            
              if(Cache.produtosCache != null){
            		  produto.salvaProdutos(Cache.produtosCache);
              }
//            	  
              
//              if(Cache.carrosCache != null){
//            		  carro.salvaCarros(Cache.carrosCache);
//              }

               
            
            Cache.produtosCache = null;
            Cache.carrosCache = null;
        }
        catch(Exception erro)
        {
            System.out.println("Erro ao iniciar: "+erro.getMessage());
        }
    }
}
