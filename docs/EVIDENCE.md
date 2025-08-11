# Evidence Capture Guide (Real Artifacts)

This project is wired to produce **real artifacts** you can show to recruiters:

## A) UI (ParaBank) – Screenshots & TestNG reports
1. Update ChromeDriver if needed.
2. Run:
   ```bash
   cd ui-tests
   mvn -q test -DsuiteXmlFile=src/test/resources/testng.xml -Dheadless=false
   ```
3. Artifacts:
   - Screenshots: `ui-tests/target/screenshots/*.png`
   - TestNG XML: `ui-tests/target/surefire-reports/*.xml`

Tip: Record a short video (Loom/OBS) logging in and running tests.

## B) API (Postman Echo + ReqRes) – Newman HTML report
```bash
cd api-tests/postman
newman run finance-credit-union.postman_collection.json -e environments/public-demo.postman_environment.json --reporters cli,html --reporter-html-export newman-report.html
```
Artifacts:
- `newman-report.html` (attach in README or commit under `docs/reports/`)

## C) HAR & Console Logs (optional)
Use Chrome DevTools to **Save all as HAR with content** for login and transfer flows. Commit HAR files under `docs/artifacts/`.

---

# Publish Proof on GitHub
```bash
git init
git add .
git commit -m "Finance Credit Union QA: UI+API tests, docs, CI"
git branch -M main
git remote add origin https://github.com/<your-username>/finance-credit-union-qa.git
git push -u origin main
```
Enable **Actions** to show CI runs publicly.

## Portfolio README Badges
- Add links to: screenshots, Newman HTML, TestNG results, CI run URL.
