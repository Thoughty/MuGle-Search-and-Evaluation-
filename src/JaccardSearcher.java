//Name: Suttichok Chotisakul, Alisa Uthikamporn, Warat Phat-in
//Section: 2
//ID: 6188014,6188025,6188035

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;	

public class JaccardSearcher extends Searcher{

	public JaccardSearcher(String docFilename) {
		super(docFilename);
		/************* YOUR CODE HERE ******************/
		
		/***********************************************/
	}

	@Override
	public List<SearchResult> search(String queryString, int k) {
		/************* YOUR CODE HERE ******************/
		List<SearchResult> result = new ArrayList<SearchResult>();
		List<String> Tokenize_String = tokenize(queryString);
		
		double score = -1;
		for(Document Doc : documents)
		{
			if(!Doc.getTokens().isEmpty() || !Tokenize_String.isEmpty())
			{
				HashSet<String> Intersect = new HashSet<>(Doc.getTokens());
				HashSet<String> Union = new HashSet<>(Doc.getTokens());
				Intersect.retainAll(Tokenize_String);
				Union.addAll(Tokenize_String);
				score = (double) Intersect.size() / Union.size();
				SearchResult DocScore = new SearchResult(Doc, score);
				result.add(DocScore);
			}
			else
			{
				score = 0.0;
				SearchResult DocScore = new SearchResult(Doc, score);
				result.add(DocScore);
			}
		}
		Collections.sort(result);
		return result.subList(0, k);
		/***********************************************/
	}

}
