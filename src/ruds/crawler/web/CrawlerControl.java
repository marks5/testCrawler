package ruds.crawler.web;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class CrawlerControl {
	
	public static void executarCrawler() throws Exception{
		
		//pasta onde dados de rastreamento intermediarios são armazenados
		String crawlStorageFolder = "C://Ferramentas//arquivos";
		
		
		// quantidade de threads simultaneas a serem iniciadas no rastreamento
		int numberOfCrawlers = 125;
		
		CrawlConfig config = new CrawlConfig();
		config.setCrawlStorageFolder(crawlStorageFolder);
		
		//segundo entre as solicitações de acesso (1000 = 1 seg)
		config.setPolitenessDelay(numberOfCrawlers);
		
		//nivel de profundidade do rastreamento (-1 = ilimitada)
		config.setMaxDepthOfCrawling(-1);
		
		// numero máximo de pagina a analisar (-1 = ilimitado)
		config.setMaxPagesToFetch(5000);
		
		
		//parametro de configuração de retomada automatica
		// caso esse recurso seja ativado o conteúdo da rootfolder deve ser apagado manualmente
		config.setResumableCrawling(false);
		
		//instanciando o controlador para rastreamento
		PageFetcher pageFetcher = new PageFetcher(config);
		RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
		CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
		
		// para cada rastreamento deve-se informar as url sementes.
		// essas urls serão as primeiras rastreadas antes do crawler começar a seguir links encontrados nessa página
		controller.addSeed("http://www.ds.ind.br/pt/");
		
		// iniciar rastreamento
		// operação de bloqueio, o código vai chegar a linha, apos isso somente quando acabar o rastreamento(?)
		controller.start(CrawlerWeb.class, numberOfCrawlers);
				
	}

}
