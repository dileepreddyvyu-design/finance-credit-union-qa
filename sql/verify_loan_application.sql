
-- Verify loan application persistence and status
-- Parameters: :application_id
SELECT la.application_id, la.amount, la.term_months, la.status, la.created_at
FROM loan_applications la
WHERE la.application_id = :application_id;
