package com.chiwawa.lionheart.api.service.member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chiwawa.lionheart.api.service.member.dto.request.CreateMemberRequestDto;
import com.chiwawa.lionheart.domain.domain.challenge.Challenge;
import com.chiwawa.lionheart.domain.domain.challenge.repository.ChallengeRepository;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.Onboarding;
import com.chiwawa.lionheart.domain.domain.member.Setting;
import com.chiwawa.lionheart.domain.domain.member.repository.MemberRepository;
import com.chiwawa.lionheart.domain.domain.member.repository.OnboardingRepository;
import com.chiwawa.lionheart.domain.domain.member.repository.SettingRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {

	private final MemberRepository memberRepository;
	private final OnboardingRepository onboardingRepository;
	private final SettingRepository settingRepository;
	private final ChallengeRepository challengeRepository;

	public Long registerMember(CreateMemberRequestDto request) {
		MemberServiceUtils.validateNotExistsMember(memberRepository, request.getSocialId(), request.getSocialType());
		Member member = memberRepository.save(
			Member.newInstance(request.getSocialId(), request.getSocialType(),
				request.getFcmToken()
			));
		Onboarding onboarding = onboardingRepository.save(Onboarding.newInstance(member, request.getPregnantWeeks(),
			request.getBabyNickname()));
		Setting setting = settingRepository.save(Setting.newInstance(member));
		Challenge challenge = challengeRepository.save(Challenge.newInstance(member));
		member.setOnboarding(onboarding);
		member.setSetting(setting);
		member.setChallenge(challenge);
		return member.getId();
	}

}

