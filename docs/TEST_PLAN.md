# Test Plan – Finance Credit Union Online Banking

## Scope
Functional, integration, and regression testing for Auth, Accounts, Transfers, Loans, and Bill Pay across Web UI and REST APIs.

## Test Types
- Smoke / Regression / UAT
- Cross-browser (Chrome, Edge, Firefox)
- Accessibility basics (axe DevTools)
- API (schema/contract, positive/negative), data-driven
- DB verification (balances, loans)

## Environments
- Web: https://demo.creditunion.local
- API: https://api.creditunion.local
- DB: Oracle/MySQL (placeholder)

## Entry / Exit
**Entry:** Dev Done, story testable, test data ready.  
**Exit:** Critical defects closed, regression pass ≥ 95%, product + QA sign-off.

## Risks & Mitigations
- Test data volatility → seeded data sets & idempotent APIs
- Flaky UI tests → explicit waits, stable locators, retry logic
- CI instability → isolate suites, parallelism control

## Reporting
- UI: TestNG XML + Extent (optional)
- API: Newman HTML
- Daily summary in CI + Confluence (sample in repo)
