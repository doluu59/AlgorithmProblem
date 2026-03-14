## 🔍 Code Quality & Review Process

본 레포지토리는 단순히 정답을 맞히는 것에 그치지 않고, **실무 수준의 코드 품질**을 유지하기 위해 AI(Gemini)를 활용한 **셀프 코드 리뷰** 프로세스를 준수합니다.

### 🚦 Code Review Workflow
1. **Issue 발행**: 구현해야 할 기능이나 알고리즘 문제 정의
2. **Feature 브랜치 생성**: `main` 브랜치 보호를 위해 기능 단위 브랜치 운용
3. **Pull Request (PR) 생성**: 코드 작성 후 Self-Review 진행
4. **AI Feedback 수렴**: 성능, 가독성, 안정성(Edge Case) 측면에서 피드백 수집
5. **Refactoring**: 지적된 사항을 반영하여 커밋 추가 (P1~P4 레벨 분류 적용)
6. **Merge**: 모든 대화(Conversation)가 Resolved된 상태에서 머지 수행

### 📈 주요 리뷰 사례 (Case Study)
| 날짜 | 문제명 | 주요 개선 내용 | 링크 |
| :--- | :--- | :--- | :--- |
| 26.03.14 | 노란 신호등 (Simulation) | ArrayIndexOutOfBounds 방어 로직 추가, 매직 넘버 상수화 | [PR #5](https://github.com/doluu59/AlgorithmProblem/pull/5) |

> **"혼자 공부하더라도 협업의 가치를 잊지 않습니다."** > 코드 리뷰를 통해 오버플로우와 같은 잠재적 버그를 사전 차단하고, `Conventional Commits` 전략을 사용하여 팀원들이 이해하기 쉬운 히스토리를 만듭니다.
