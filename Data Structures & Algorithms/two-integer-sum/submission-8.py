class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        sum_map = {}

        for i in range(len(nums)):
            if nums[i] in sum_map:
                return [sum_map[nums[i]], i]
            sum_map[target - nums[i]] = i

        return []
