# Finance Credit Union – Online Banking QA
End-to-end QA portfolio project covering **Web UI** and **REST API** testing for a fictional credit union's online banking platform.  
Stack mirrors my resume: **Java, Selenium WebDriver, TestNG, REST Assured (optional), Postman/Newman, Jenkins/GitHub Actions, SQL, Jira/Zephyr**.

## Key Features
- POM-based Selenium framework (parallel-ready) with TestNG suites and data-driven examples
- API coverage via Postman collection + Newman CLI (and a small REST Assured sample)
- CI pipelines (GitHub Actions + Jenkinsfile)
- SQL validation scripts for balances and loan applications
- Documentation: Test Plan, RTM, QA Summary, and Defect Template

## Modules Covered
1. Authentication & Security (login, logout, lockout)
2. Accounts (balances, transactions, statements)
3. Transfers (internal/external, limits)
4. Loans (application, eligibility, status)
5. Bill Pay (add biller, schedule/cancel payments)

## How to run (UI)
```bash
cd ui-tests
mvn -q -DskipTests=false test -DsuiteXmlFile=src/test/resources/testng.xml
# headless
mvn -q test -DsuiteXmlFile=src/test/resources/testng.xml -Dheadless=true
```

## How to run (API via Newman)
```bash
cd api-tests/postman
newman run finance-credit-union.postman_collection.json -e environments/local.postman_environment.json --reporters cli,html --reporter-html-export newman-report.html
```

## REST Assured sample (optional)
```bash
cd ui-tests
mvn -q -Dtest=ApiSmokeTest test
```

## CI
- GitHub Actions workflow: `.github/workflows/ci.yml`
- Jenkins: `Jenkinsfile`

## Folder Structure
```
finance-credit-union-qa/
  ui-tests/
  api-tests/postman/
  sql/
  docs/
  .github/workflows/
```

> This is a showcase project intended for recruiters and hiring managers.

## Evidence: Test Run Videos
- ▶️ **UI test run (opens website):** [docs/test-runs/finance-cu-qa-test-run-1.mov](docs/test-runs/finance-cu-qa-test-run-1.mov)
- ▶️ **API run (opens Newman report):** [docs/test-runs/finance-cu-qa-test-run-2.mov](docs/test-runs/finance-cu-qa-test-run-2.mov)

