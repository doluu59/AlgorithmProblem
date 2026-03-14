# 📝 Algorithm Study & Engineering Practice

> **"혼자 공부하더라도 협업의 가치를 잊지 않습니다."** > 단순히 문제를 푸는 것을 넘어, 실무 수준의 시스템 안정성과 유지보수 가능한 코드를 지향합니다.

## 🏃‍♂️ 1일 1알고리즘 챌린지 (Daily Coding)
- **시작일**: 2025년 12월 16일
- **유지 기간**: **90일차** (2026.03.14 기준)
- **기록의 목적**: 
  - 취업 준비 기간 중 발생할 수 있는 공백기 동안 **학습의 연속성**을 증명.
  - 매일 직면하는 문제를 해결하며 **꾸준히 성장하는 개발자**임을 데이터로 기록.
- **나의 다짐**: 실패를 두려워하지 않되, 실패로부터 원인을 분석하고 다시 궤도에 오르는 복원력을 유지합니다.

### ⚠️ 미이행 기록 (Exception Logs)
| 날짜 | 사유 | 대응 및 후속 조치 |
| :--- | :--- | :--- |
| 2026.01.13 | 개인 사유 | 익일 00시 56분 누락된 문제 풀이 학습 완료  |
| 2026.03.06 | 개인 사유 | 익일 1시 21분 누락된 문제 풀이 업로드|

---

## 🛠️ Engineering Practice & Convention

본 레포지토리는 효율적인 문제 해결뿐만 아니라, **현업 수준의 협업 능력과 코드 품질 유지**를 목적으로 아래의 컨벤션들을 엄격히 준수합니다.

### 1. 📂 Project Structure & Clean Code
- **Domain-Based Directory**: 알고리즘 유형 및 플랫폼별로 폴더를 구조화하여 관리합니다.
- **Java Naming Convention**:
    - 변수 및 메서드명은 **Lower Camel Case**(`variableName`)를 사용합니다.
    - 클래스명은 **Upper Camel Case**(`ClassName`)를 사용합니다.
    - 상수는 **Upper Case with Underscore**(`STATIC_CONSTANT`)를 사용하여 의미를 명확히 합니다.
- **Self-Documenting Code**: 매직 넘버를 지양하고 의미 있는 변수명을 사용하여 주석 없이도 읽히는 코드를 지향합니다.

### 2. 💬 Git Commit & PR Convention
현업의 협업 프로세스를 간접 체험하기 위해 **Conventional Commits** 전략을 사용합니다.

- **Commit Message Type**:
    - `Feat`: 새로운 문제 해결 코드 추가
    - `Refactor`: 코드 리뷰 반영 및 로직/구조 개선
    - `Fix`: 버그 수정 및 예외 처리 추가
    - `Docs`: README 등 문서 수정
- **Workflow**: 
    - 문제 해결 시 `develop` 혹은 `feature` 브랜치에서 작업 후 PR 생성.
    - 모든 리뷰 대화(Conversation)가 **Resolved** 된 후에만 `main` 브랜치로 머지하여 깨끗한 히스토리 유지.

---

## 🔍 Code Quality & Review Process

작성한 코드의 맹점을 객관적으로 파악하기 위해 AI(Gemini)를 활용한 **셀프 코드 리뷰** 프로세스를 운영합니다.

### 🚦 Review Strategy
1. **AI Feedback 수렴**: 성능, 가독성, 안정성(Edge Case) 측면에서 피드백 수집.
2. **P-Level 분류**: 피드백의 중요도에 따라 P1(Critical) ~ P4(Minor) 등급을 부여하여 관리.
3. **Refactoring**: 지적된 사항(오버플로우, 인덱스 초과, 확장성 부족 등)을 반영하여 최종 코드 완성.

### 📈 주요 리뷰 사례 (Case Study)
| 날짜 | 문제명 | 주요 개선 내용 | 링크 |
| :--- | :--- | :--- | :--- |
| 2026.03.14 | 노란 신호등 (Simulation) | ArrayIndexOutOfBounds 방어 로직 추가, 매직 넘버 상수화 | [PR #5](https://github.com/doluu59/AlgorithmProblem/pull/5) |

---
