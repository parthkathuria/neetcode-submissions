class Solution:
    delimiter = "#"

    def encode(self, strs: List[str]) -> str:
        encoded_str = ""
        for s in strs:
            encoded_str += f"{len(s)}{self.delimiter}{s}"
        return encoded_str

    def decode(self, s: str) -> List[str]:
        decoded_str = []

        i = 0
        while i < len(s):
            j = i
            while s[j] != self.delimiter:
                j += 1
            length = int(s[i:j])
            i = j + 1
            j = i + length
            decoded_str.append(s[i:j])
            i = j
            
        
        return decoded_str
