#!/usr/bin/env bash
newman run finance-credit-union.postman_collection.json -e environments/local.postman_environment.json --reporters cli,html --reporter-html-export newman-report.html
