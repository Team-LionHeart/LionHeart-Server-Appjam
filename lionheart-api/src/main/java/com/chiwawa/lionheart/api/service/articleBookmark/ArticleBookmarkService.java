package com.chiwawa.lionheart.api.service.articleBookmark;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chiwawa.lionheart.api.service.articleBookmark.dto.request.UpdateArticleBookmarkRequest;
import com.chiwawa.lionheart.api.service.member.MemberServiceUtils;
import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.repository.ArticleRepository;
import com.chiwawa.lionheart.domain.domain.articlebookmark.ArticleBookmark;
import com.chiwawa.lionheart.domain.domain.articlebookmark.repository.ArticleBookmarkRepository;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class ArticleBookmarkService {

	private final ArticleBookmarkRepository articleBookmarkRepository;
	private final MemberRepository memberRepository;
	private final ArticleRepository articleRepository;

	public void updateArticleBookmark(Long memberId, UpdateArticleBookmarkRequest request) {
		Member member = MemberServiceUtils.findMemberById(memberRepository, memberId);
		Article article = ArticleBookmarkServiceUtils.findArticleById(articleRepository, request.getArticleId());
		Optional<ArticleBookmark> articleBookmark = articleBookmarkRepository.findArticleBookmarkByMemberAndArticle(
			member, article);

		ArticleBookmarkServiceUtils.validateBookmarkRequest(
			articleBookmark,
			request.isBookmarkStatus());

		if (request.isBookmarkStatus()) {
			articleBookmarkRepository.save(ArticleBookmark.newInstance(member, article));
		}
		if (!request.isBookmarkStatus()) {
			articleBookmarkRepository.delete(articleBookmark.get());
		}
	}
}