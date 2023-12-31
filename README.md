# 쇼핑몰 프로젝트
[![Java CI with Gradle](https://github.com/catveloper365/project-shop/actions/workflows/ci_gradle_build.yml/badge.svg?branch=main)](https://github.com/catveloper365/project-shop/actions/workflows/ci_gradle_build.yml)

## 브랜치 전략
GitHub Flow 사용<br>
<img src="https://user-images.githubusercontent.com/6351798/48032310-63842400-e114-11e8-8db0-06dc0504dcb5.png" width="600"><br>
- main 브랜치 : 최신/배포 브랜치
- 작업 브랜치 : main 브랜치를 통해 생성하여 작업 진행
  - 작업 브랜치명 형식 : `[작업 종류]/이슈번호-작업내용`
  - 작업 종류를 통해 브랜치의 의도를 구분 
    1. 기능 개발 : feature
    2. 버그 수정 : hotfix

## 커밋 메세지 규칙
- 커밋 제목 작성 형식
  - `커밋 타입: [이슈번호] 커밋 제목`
- 커밋 타입 종류
  - `New`      : 새로운 기능 추가
  - `Improve`  : 기존 기능 수정, 요구사항 변경
  - `Fix`      : 버그 수정
  - `Test`     : 테스트 코드 추가/수정/삭제, 비즈니스 로직 변경X
  - `Refactor` : 코드 리팩토링
  - `Design`   : CSS 등 사용자 UI 디자인 변경
  - `Style`    : 코드 포맷팅/컨벤션, 세미콜론 추가, 비즈니스 로직 변경X
  - `Chore`    : 배포/빌드 업무 등 프로젝트 관련 작업, 기타 변경 사항
  - `Release`  : 패키지 버전 변경 등 릴리즈 위한 작업
  - `Docs`     : 문서 추가/수정/삭제
  - `Rename`   : 파일 혹은 폴더명을 수정하거나 옮기는 작업만 하는 경우
  - `Remove`   : 파일을 삭제하는 작업만 수행한 경우