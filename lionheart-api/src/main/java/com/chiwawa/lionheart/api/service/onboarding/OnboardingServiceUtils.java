package com.chiwawa.lionheart.api.service.onboarding;

import static com.chiwawa.lionheart.common.constant.message.OnboardingErrorMessage.*;
import static com.chiwawa.lionheart.common.exception.ErrorCode.*;

import com.chiwawa.lionheart.common.exception.model.NotFoundException;
import com.chiwawa.lionheart.common.util.MessageUtils;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.Onboarding;
import com.chiwawa.lionheart.domain.domain.member.repository.OnboardingRepository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OnboardingServiceUtils {

	public static Onboarding findOnboardingByMember(OnboardingRepository onboardingRepository, Member member) {
		return onboardingRepository.findOnboardingByMember(member)
			.orElseThrow(
				() -> new NotFoundException(MessageUtils.generate(NOT_EXIST_ONBOARDING_OF_USER_MESSAGE, member.getId()),
					NOT_FOUND_ONBOARDING_OF_USER_EXCEPTION));
	}
}
