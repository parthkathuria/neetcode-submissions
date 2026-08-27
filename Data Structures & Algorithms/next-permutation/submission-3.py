class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        # find pivot
        pivot = 0
        for i in range(n - 1, 0, -1):
            if nums[i - 1] < nums[i]:
                pivot = i
                break

        if pivot == 0:
            nums.sort()
            return

        # find the swap - number > pivot - 1
        swap = n - 1
        while nums[pivot - 1] >= nums[swap]:
            swap -= 1

        # swap
        nums[pivot - 1], nums[swap] = nums[swap], nums[pivot - 1]

        # reverse after pivot
        l = pivot
        r = n - 1
        while l < r:
            tmp = nums[l]
            nums[l] = nums[r]
            nums[r] = tmp
            l += 1
            r -= 1

        return
