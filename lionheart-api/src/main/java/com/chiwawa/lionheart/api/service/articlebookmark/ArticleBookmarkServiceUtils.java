package com.chiwawa.lionheart.api.service.articlebookmark;

import static com.chiwawa.lionheart.common.constant.message.ArticleBookmarkErrorMessage.*;
import static com.chiwawa.lionheart.common.exception.ErrorCode.*;

import java.util.Optional;

import com.chiwawa.lionheart.common.exception.model.ConflictException;
import com.chiwawa.lionheart.common.util.MessageUtils;
import com.chiwawa.lionheart.domain.domain.articlebookmark.ArticleBookmark;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleBookmarkServiceUtils {

	public static void validateBookmarkRequest(Optional<ArticleBookmark> articleBookmark, boolean bookmarkRequestStatus) {
		if (bookmarkRequestStatus == true && articleBookmark.isPresent()) {
			throw new ConflictException(
				MessageUtils.generate(ALREADY_EXIST_BOOKMARK_ERROR_MESSAGE, articleBookmark.get().getId()),
				CONFLICT_BOOKMARK_EXCEPTION);
		}
		if (bookmarkRequestStatus == false && articleBookmark.isEmpty()) {
			throw new ConflictException(ALREADY_EMPTY_BOOKMARK_ERROR_MESSAGE, CONFLICT_BOOKMARK_EXCEPTION);
		}
	}
}