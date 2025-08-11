
-- Verify that account balance reflects latest transfer
-- Parameters: :account_id
SELECT a.account_id, a.balance, t.amount, t.created_at
FROM accounts a
LEFT JOIN transfers t ON (t.to_account_id = a.account_id OR t.from_account_id = a.account_id)
WHERE a.account_id = :account_id
ORDER BY t.created_at DESC
FETCH FIRST 10 ROWS ONLY;
