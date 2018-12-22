
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.news.model.Articles;
import com.news.model.NewsContents;
import com.news.model.NewsResponse;
import com.news.service.NewsService;


@RunWith(MockitoJUnitRunner.class)
public class NewsServiceTest {
	
	@InjectMocks
	NewsService newsService;
	
	@Mock
	RestTemplate restTemplate;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void getNewsTest() {
		Articles article = new Articles("title", "description", "url");
		List<Articles> articles = new ArrayList<Articles>();
		articles.add(article);
		
		NewsContents data = new NewsContents();
		data.setArticles(articles);
		
		ResponseEntity<NewsContents> resp = new ResponseEntity<NewsContents>(data, HttpStatus.OK);
		
		String url = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=ccaf5d41cc5140c984818c344edcc14d";
		
		Mockito.when(restTemplate.getForEntity(url, NewsContents.class)).thenReturn(resp);
		List<NewsResponse> responses = newsService.getNews("us", "business", "test");
		Assert.assertTrue(responses.size() == 1);
	}
	
	@Test
	public void getNewsFailedTest() {
		Articles article = new Articles("title", "description", "url");
		List<Articles> articles = new ArrayList<Articles>();
		articles.add(article);
		
		NewsContents data = new NewsContents();
		data.setArticles(articles);
		
		ResponseEntity<NewsContents> resp = new ResponseEntity<NewsContents>(data, HttpStatus.OK);
		
		String url = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=ccaf5d41cc5140c984818c344edcc14d";
		
		List<NewsResponse> responses = newsService.getNews("us1", "business", "test");
		Assert.assertTrue(responses.size() == 0);
	}
}