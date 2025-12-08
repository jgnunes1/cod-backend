#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR=$(cd "$(dirname "$0")/.." && pwd)
SQL_FILE="$ROOT_DIR/scripts/create_mysql_user.sql"

if ! command -v mysql >/dev/null 2>&1; then
  echo "Cliente 'mysql' não encontrado. Instale o cliente MySQL e rode: mysql -u root -p < $SQL_FILE"
  exit 1
fi

echo "Tentando aplicar script SQL usando 'sudo mysql' (pode pedir sua senha)..."
if sudo mysql < "$SQL_FILE"; then
  echo "Script executado com sudo mysql com sucesso.";
  exit 0
fi

echo "Falha ao executar com sudo mysql. Tente executar manualmente:" 
echo "  sudo mysql < $SQL_FILE"
echo "ou" 
echo "  mysql -u root -p < $SQL_FILE"

exit 1
