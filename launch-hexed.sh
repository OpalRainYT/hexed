#!/bin/bash
# Hexed Client Launcher for macOS and Linux
# Opens the Hexed client in your default browser

if [[ "$OSTYPE" == "linux-gnu"* ]]; then
    xdg-open https://opalrainyc.github.io/hexed/
elif [[ "$OSTYPE" == "darwin"* ]]; then
    open https://opalrainyc.github.io/hexed/
else
    echo "Unsupported OS"
fi
