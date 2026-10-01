#!/bin/bash
# Hexed launcher for Linux/macOS.
# Opens the local Hexed client page from the same directory.

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"

if command -v xdg-open >/dev/null 2>&1; then
  xdg-open "$SCRIPT_DIR/index.html"
elif command -v open >/dev/null 2>&1; then
  open "$SCRIPT_DIR/index.html"
else
  echo "Could not open index.html automatically. Open it manually from this folder."
  exit 1
fi
