package com.chiwawa.lionheart.api.service.articlebookmark;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chiwawa.lionheart.api.service.articlebookmark.dto.response.ArticleBookmarkResponse;
import com.chiwawa.lionheart.api.service.member.MemberServiceUtils;
import com.chiwawa.lionheart.domain.domain.articlebookmark.ArticleBookmark;
import com.chiwawa.lionheart.domain.domain.articlebookmark.repository.ArticleBookmarkRepository;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ArticleBookmarkRetrieveService {
	private final ArticleBookmarkRepository articleBookmarkRepository;
	private final MemberRepository memberRepository;

	public ArticleBookmarkResponse getArticleBookmark(Long memberId) {
		Member member = MemberServiceUtils.findMemberById(memberRepository, memberId);
		List<ArticleBookmark> articleBookmarks = articleBookmarkRepository.findArticleBookmarksByMember(member);
		return ArticleBookmarkResponse.of(member, articleBookmarks);
	}
}
