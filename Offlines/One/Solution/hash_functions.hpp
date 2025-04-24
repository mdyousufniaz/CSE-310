#ifndef HASH_FUNCTIONS_HPP
#define HASH_FUNCTIONS_HPP

#include <string>

unsigned int SDBMHash(const std::string& str, unsigned int num_buckets) {
    unsigned int hash = 0;
    unsigned int len = str.length();

    for (unsigned int i = 0; i < len; i++) hash = ((str[i]) + (hash << 6) + (hash << 16) - hash) % num_buckets;

    return hash;
}

unsigned int DJB2aHash(const std::string& str, unsigned int num_buckets){
    unsigned int hash = 5381U;                 // seed
    for (unsigned char c : str)
        hash = ((hash << 5) + hash) ^ c;       // hash * 33 ^ c
    return hash % num_buckets;                 // final bucket index
}

unsigned int FNV1aHash(const std::string& str, unsigned int num_buckets){
    const unsigned int FNV_OFFSET = 2166136261U;
    const unsigned int FNV_PRIME  = 16777619U;

    unsigned int hash = FNV_OFFSET;
    for (unsigned char c : str)
        hash = (hash ^ c) * FNV_PRIME;         // XOR then multiply
    return hash % num_buckets;                 // final bucket index
}

unsigned int (*getHashFunc(unsigned int num)) (const std::string&, unsigned int) {
    switch (num) {
        case 1:
            return SDBMHash;
        case 2:
            return DJB2aHash;
        case 3:
            return FNV1aHash;
        default:
            return nullptr;
    }
}

#endif