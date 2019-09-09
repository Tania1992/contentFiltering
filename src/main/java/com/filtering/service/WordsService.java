package com.filtering.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filtering.dao.WordsDao;

@Service
public class WordsService {
	
	@Autowired
	WordsDao wordsdao;
	
	public boolean checkSpam(String text)
	{
		String words[] = text.split(" ");
		double hamFrequency =0;
		double spamFrequency = 0;
		double totalSpamFrequency = 0;
		double totalHamFrequency = 0;
		totalSpamFrequency = wordsdao.totalWords("spam");
		totalHamFrequency = wordsdao.totalWords("ham");
		double totalWords = totalHamFrequency + totalSpamFrequency;
		for(int i=0;i<words.length;i++)
		{
			hamFrequency = hamFrequency + wordsdao.checkFrequency(words[i].toLowerCase(), "ham");
			spamFrequency = spamFrequency + wordsdao.checkFrequency(words[i].toLowerCase(), "spam");
		}
		
		double hamProbability = hamFrequency/(totalHamFrequency + totalWords);
		double spamProbability = spamFrequency/(totalSpamFrequency + totalWords);
		
		if(hamProbability>spamProbability)
		{
			return false;
		}
		return true;
	}

}
