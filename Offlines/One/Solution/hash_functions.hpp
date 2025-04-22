#ifndef HASH_FUNCTIONS_HPP
#define HASH_FUNCTIONS_HPP

#include <string>

static unsigned int SDBMHash(std::string str, unsigned int num_buckets) {
    unsigned int hash = 0;
    unsigned int len = str.length();

    for (unsigned int i = 0; i < len; i++) hash = ((str[i]) + (hash << 6) + (hash << 16) - hash) % num_buckets;

    return hash;
}

static unsigned int (*getHashFunc(unsigned int num)) (std::string, unsigned int) {
    switch (num) {
        case 1:
            return SDBMHash;
        default:
            return nullptr;
    }
}

#endif