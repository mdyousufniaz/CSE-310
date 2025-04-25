#!/usr/bin/env bash
# copy_and_prefix.sh  usage: ./copy_and_prefix.sh <src_dir> <dst_dir>

set -euo pipefail      # safer bash: exit on error / unset / pipe fail

SRC="D:\Git_Folders\CSE-310\Offlines\One\Solution"
DST="C:\Users\mdyou\OneDrive - BUET\Desktop\TEMP"

mkdir -p "$DST"        # make destination if it doesn’t exist

for f in "$SRC"/*.{hpp,cpp,csv}; do   # brace‑expand the 3 extensions
    [[ -e "$f" ]] || continue         # skip if no match for that ext
    base=$(basename "$f")
    cp -- "$f" "$DST/2105125_$base"
done
